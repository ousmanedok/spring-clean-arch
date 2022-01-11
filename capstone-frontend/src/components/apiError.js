import errorImage from "../error.png";
const ApiError = (props) =>{
    return(
        <div>
            {
                props.message && (
                    <div className="blocError">
                        <div className="errorImage">
                            <img src={errorImage} alt=""/>
                        </div>
                        <p>{props.message}</p>      
                    </div>
                )
            }
        </div>
    );
}

export default ApiError;