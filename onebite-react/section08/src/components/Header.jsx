import './Header.css';

const Header = ()=> {
    return (
        <div calssName="Header">
            <h3>TODAY📆</h3>
            <h1>{new Date().toDateString()}</h1>
            
        </div>
    );
};

export default Header;