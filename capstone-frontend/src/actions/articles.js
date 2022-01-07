import {RETRIEVE_ARTICLES}  from "./types";
  
  import ArticleService from "../services/article.service";
  
  export const retrieveArticles = () => async (dispatch) => {
    try {
      const limit = 10;
      const res = await ArticleService.getArticles(limit);
      dispatch({
        type: RETRIEVE_ARTICLES,
        payload: res.data.data,
      });

    } catch (err) {
      console.log(err);
    }
  };