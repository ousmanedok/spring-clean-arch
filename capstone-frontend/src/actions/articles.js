import {RETRIEVE_ARTICLES , API_ERROR}  from "./types";
  
  import ArticleService from "../services/article.service";
  
  export const retrieveArticles = (limit=10) => async (dispatch) => {
    try {
      const res = await ArticleService.getArticles(limit);
      dispatch({
        type: RETRIEVE_ARTICLES,
        payload: res.data.data,
      });
    } catch (err) {
      const message = `Une erreur est survenue lors de la récupération des articles : ${err?.message}`;
      dispatch({
        type: API_ERROR,
        payload: message
      });
    }
  };