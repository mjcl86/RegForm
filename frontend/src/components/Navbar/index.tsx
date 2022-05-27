import { ReactComponent as GitHubIcon } from 'assets/img/github.svg';
import { ReactComponent as HnLogo } from 'assets/img/hnlogo.svg';
import './styles.css';

function Navbar() {
    return (
        <header>
            <nav className='container'>
                <div className='regform-nav-content'>
                    <HnLogo />
                    <a href="https://github.com/mjcl86" className='regform-nav-github'>
                        <div>
                            <GitHubIcon />
                            <p>/mjcl86</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;