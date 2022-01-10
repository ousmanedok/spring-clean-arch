import {RETRIEVE_ARTICLES , API_ERROR}  from "./types";
  
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
      const messageError = `Une erreur est survenue lors de la récupération des articles : ${err?.message}`;
      dispatch({
        type: API_ERROR,
        payload: messageError
      });
    }
  };