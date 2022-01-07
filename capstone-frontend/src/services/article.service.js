import http from "../http-common";


  const getArticles = limit => {
    return http.get(`/api/articles/list?limit=${limit}`);
  }

  const ArticleService = {
    getArticles
  };

export default  ArticleService;