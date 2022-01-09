import ArticleElement from "./articleElement";
import ApiError from "../apiError";
import {retrieveArticles} from "../../actions/articles";
import React, {  useEffect } from "react";
import { useDispatch, useSelector } from "react-redux";

const ArticleList =() =>{
    const articles     = useSelector(state => state?.article?.articles);
    const messageError = useSelector(state => state?.article?.messageError);
    const dispatch = useDispatch();
    useEffect(() => {
        dispatch(retrieveArticles());
      }, []);
    return(
            <div>
                    {
                        messageError ? (
                            <ApiError messageError = {messageError}/>
                        ):(
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
                        )
                    }    
            </div>  
           
    );
}
export default ArticleList;