const Button = ({children, text, color="black"}) => {
    return (
        <button
            onClick={() => {
                console.log(text);
            }}
            style={{color: color}}
        >
            {text} - {color.toUpperCase()}
            {children}
        </button>
    ) 
}

export default Button; 