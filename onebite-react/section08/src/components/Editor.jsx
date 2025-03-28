import "./Editor.css"

const Editor = ()=> {
    return (
        <div className="Editor">
            <input type="text" placeholder="new TODO"/>
            <button id="onClick">SUBMIT</button>
        </div>
    );
};

export default Editor;