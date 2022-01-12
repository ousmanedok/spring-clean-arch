import ArticleList from './components/articles/articlesList';
import Header from './components/header';
import "bootstrap/dist/css/bootstrap.min.css";
import ApiError from './components/apiError';
import {useSelector} from "react-redux";

function App() {
  const message = useSelector(state => state?.apiError?.message);
  return (
    <div className="App">
      <Header/>
      <div className="container">
          <div className="row mt-5 ">
              <div className="col col-md-12 ">
                <ApiError message={message}/>
                <ArticleList/>
              </div>  
              
          </div>
      </div>
    </div>
  );
}

export default App;
