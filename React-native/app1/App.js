import React from 'react';
import ArticleList from './components/articleList';
import Header from './components/header';
import ApiError from './components/apiError';
import {useSelector } from "react-redux";

const App = () => {
  const message = useSelector(state => state?.apiError?.message);
  return (
        <>
            <Header/>
            <ApiError message={message}/>
            <ArticleList/>
        </> 
    
  );
}

export default App;