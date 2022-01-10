const ArticleElement = (props) =>{
    const date = new Date(props.publishedDate);
    return(
        <div className="d-flex flex-row w3-hover-opacity mb-4 new ">
                <div className="col col-md-3 col-sm-12 col-xs-12 ">
                    <img className="articleImage"  src={props.imageUrl}/>              
                </div>
                <div className="col col-md-9 p-2 col-sm-12 col-xs-12 ">
                    <a className="titre" href={props?.url}><h2>{props.title}</h2></a>
                    <p className="infoPlus">guineenews.org<span style = {{ marginLeft : 20 }}>{date.toDateString()} {date.getHours()}h:{date.getMinutes()}</span></p>
                    <p>
                        {props.content} 
                    <span>  <a href={props.url}>voir plus ...</a></span>
                    </p>
                    <p className="infoPlus">{props.author}</p>
                </div>          
            </div>
    );
}



export default ArticleElement;