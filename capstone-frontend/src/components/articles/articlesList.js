import ArticleElement from "./articleElement";
import {retrieveArticles} from "../../actions/articles";
import React, {  useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";

const ArticleList =() =>{
    const articles = useSelector(state => state?.article?.articles);
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(retrieveArticles());

      }, []);
    return(
        <div>
            {
                articles?.map((article , index) => (
                    <ArticleElement 
                        key = {index}    
                        title = {article.title}
                        url = {article.url}
                        content = {article.content}
                        imageUrl = {article.imageUrl}
                        author = {article.author}
                        publishedDate = {article.publishedDate}
                    />
                ))
            }   
        </div>    
    );
}
export default ArticleList;