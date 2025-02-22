import {useRef, useState} from "react"
// sign up form
// 1. name
// 2. birth
// 3. nationality
// 4. intro

const Register = ()=>{

    const [input, setInput] = useState({
        name: "",
        birth: "",
        country: "",
        bio: "",
    });

    const countRef = useRef(0);
    const inputRef = useRef();

    const onChange = (e) =>{
        countRef.current++;
        console.log(countRef.current);
        setInput({
          ...input,
          [e.target.value] : e.target.value,
        })
    }

    const onSubmit = () => {
        if(input.name === ""){
            //이름을 입력하는 DOM요소 포커스
            // console.log(inputRef.current);
            inputRef.current.focus();
        }
    }

    return (
        <div>
            <div>
                <input ref={inputRef} name="name" value={input.name} onChange={onChange} placeholder={"NAME"}/>
                {input.name}
            </div>
            <div>
                <input value={input.birth} onChange={onChange} type="date" />
            </div>
            <div>
                <select value={input.country} onChange={onChange}>
                    <option></option>
                    <option value="kr">Korea</option>
                    <option value="ca">Canada</option>
                    <option value="us">US</option>
                    <option value="uk">UK</option>
                </select>
                {input.country}
            </div>
            <div>
                <textarea value={input.bio} onChange={onChange}/>
            </div>

            <button onClick={onSubmit}>submit</button>
        </div>
    )
};

export default Register;