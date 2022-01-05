const ArticleElement = (props) =>{
    return(
        <div className="d-flex flex-row w3-hover-opacity mb-4 new ">
                <div className="col col-md-3 col-sm-12 col-xs-12 ">
                    <img className="newImage"  src={props.imageUrl}/>              
                </div>
                <div className="col col-md-9 p-2 col-sm-12 col-xs-12 ">
                    <a className="titre" href="#"><h1>{props.title}</h1></a>
                    <p className="infoPlus">{props.url}<span style = {{ marginLeft : 20 }}>{props.publishedDate}</span></p>
                    <p>
                        {props.content} 
                    <span>  <a href="#">voir plus ...</a></span>
                    </p>
                    <p className="infoPlus">{props.author}</p>
                </div>          
            </div>
    );
}

export default ArticleElement;

