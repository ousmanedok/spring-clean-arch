import ArticleList from './components/articles/articlesList';
import Header from './components/header';
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  return (
    <div className="App">
      <Header/>
      <div className="container">
          <div className="row mt-5 ">
              <div className="col col-md-12 ">
                <ArticleList/>
              </div>  
              
          </div>
      </div>
    </div>
  );
}

export default App;
