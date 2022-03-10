import {ReactComponent as GithubIcon} from 'assets/img/github.svg'
import './styles.css';

function NavBar(){
    return(
        <header>
        <nav className="container">
          <div className="dsmovie-nav-content">
            <h1>DSMovie-Prof</h1>
            <a href="https://github.com/crisurubu/dsmoveie-prof" >
              <div className="dsmovie-contact-container">
                <GithubIcon />
                <p className="dsmovie-contact-link">/crisurubu</p>
              </div>
            </a>
          </div>
        </nav>
      </header>
    )
}

export default NavBar;