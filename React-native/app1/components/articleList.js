import React, {  useEffect } from "react";
import { FlatList} from 'react-native';
import ArticleElement from './articleElement';
import { useDispatch, useSelector } from "react-redux";
import {retrieveArticles} from '../actions/articles';

const ArticleList = ({route}) =>{

    const articles     = useSelector(state => state?.articleReducer?.articles);
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(retrieveArticles());
      }, []);
      
    const renderItem = ({ item }) => (
        <ArticleElement
            key = {item.id}
            title = {item.title}
            url = {item.url}
            content = {item.content} 
            publishedDate = {item.publishedDate}
            imageUrl = {item.imageUrl}
            author = {item.author}
            siteName = {item.siteName}
        />
      );
    return(
            <FlatList
                data={articles}
                renderItem={renderItem}
                keyExtractor={item => item.id}
            />
    );
}
export default ArticleList;