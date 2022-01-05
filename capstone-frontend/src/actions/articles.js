import {RETRIEVE_ARTICLES}  from "./types";
  
  import ArticleDataService from "../services/article.service";
  
  export const retrieveArticles = () => async (dispatch) => {
    try {
      const limit = 10;
      const res = await ArticleDataService.getAll(limit);
      dispatch({
        type: RETRIEVE_ARTICLES,
        payload: res.data.data,
      });

      console.log(res.data)

    } catch (err) {
      console.log(err);
    }
  };

  
  
  
  
  
 
  
 