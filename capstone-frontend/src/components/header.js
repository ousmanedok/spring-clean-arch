export default function Header(){
    return (
        <header>
                <nav className="navbar navbar-expand-lg navbar-light  w3-cyan">
                        <div className="container">
                            <a className="navbar-brand w3-text-white w3-xxlarge" href="#">News</a>
                            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                            </button>
                            <div className="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                                <li className="nav-item">
                                <a className="nav-link active w3-text-white w3-xlarge" aria-current="page" href="#">Accueil</a>
                                </li>
                                <li className="nav-item">
                                <a className="nav-link w3-text-white w3-xlarge" href="#">Favorie</a>
                                </li>
                            </ul>
                            <form className="d-flex">
                                <input className="form-control me-2" type="search" placeholder="recherche" aria-label="Search"/>
                                <button className="btn btn-outline w3-border w3-border-white w3-text-white" type="submit">Rechercher</button>
                            </form>
                            </div>
                        </div>
                </nav>
            </header>
    );
}