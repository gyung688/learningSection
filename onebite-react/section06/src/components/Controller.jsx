
const Controller = ({onClickCount}) => {
    return (
        <div>
            <div>
                <button onClick={()=>{onClickCount(-1)}}>-1</button>
                <button onClick={()=>{onClickCount(-10)}}>-10</button>
                <button onClick={()=>{onClickCount(-100)}}>-100</button>
                <button onClick={()=>{onClickCount(100)}}>+100</button>
                <button onClick={()=>{onClickCount(10)}}>+10</button>
                <button onClick={()=>{onClickCount(1)}}>+1</button>
            </div>
        </div>
    )
}

export default Controller;