import errorImage from "../error.png";
const ApiError = (props) =>{
    return(
        <div className="blocError">
            <div className="errorImage">
                <img src={errorImage} alt=""/>
            </div>
             <p>{props.messageError}</p>      
        </div>
    );
}

export default ApiError;