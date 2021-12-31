export default function ArticleElement(){
    return(
        <div className="d-flex flex-row w3-hover-opacity mb-4 new ">
                <div className="col col-md-3 col-sm-12 col-xs-12 ">
                    <img className="newImage"  src='https://guineenews.org/wp-content/uploads/2021/10/247639421_587139499374891_8761184434803523300_n-720x430.jpg'/>              
                </div>
                <div className="col col-md-9 p-2 col-sm-12 col-xs-12 ">
                    <a className="titre" href="#"><h1>New  1</h1></a>
                    <p className="infoPlus">,fnrjjirnj.com<span style = {{ marginLeft : 20 }}>2021</span></p>
                    <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                    tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                    quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo  
                    <span>  <a href="#">voir plus ...</a></span>
                    </p>
                    <p className="infoPlus">Amina chérif</p>
                </div>          
            </div>
    );
}