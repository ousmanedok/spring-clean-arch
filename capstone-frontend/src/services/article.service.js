import http from "../http-common";


  const getAll = limit => {
    return http.get(`/api/articles/list?limit=${limit}`);
  }

  const ArticleDataService = {
    getAll
  };

export default  ArticleDataService;