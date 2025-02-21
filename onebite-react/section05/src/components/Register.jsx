import {useState} from "react"
// sign up form
// 1. name
// 2. birth
// 3. nationality
// 4. intro

const Register = ()=>{
    const [name, setName] = useState("name");
    const [birth, setBirth] = useState("");
    const [country, setCountry] = useState("");
    const [bio, setBio] = useState("");

    const onChangeName = (e)=>{
        setName(e.target.value);
    }
    
    const onChangeBirth = (e)=>{
        setBirth(e.target.value);
    }

    const onChangeCountry = (e)=>{
        setCountry(e.target.value);
    }

    const onChangeBio = (e)=>{
        setBio(e.target.value);
    }


    return (
        <div>
            <div>
                <input value={name} onChange={onChangeName} placeholder={"NAME"}/>
                {name}
            </div>
            <div>
                <input value={birth} onChange={onChangeBirth} type="date" />
            </div>
            <div>
                <select value={country} onChange={onChangeCountry}>
                    <option></option>
                    <option value="kr">Korea</option>
                    <option value="ca">Canada</option>
                    <option value="us">US</option>
                    <option value="uk">UK</option>
                </select>
                {country}
            </div>
            <div>
                <textarea value={bio} onChange={onChangeBio}/>
            </div>
        </div>
    )
};

export default Register;