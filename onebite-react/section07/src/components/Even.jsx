import {useEffect} from "react";

const Even = () => {
    useEffect(() => {
        return () => {
            console.log('unmount')
        };
    })
    return <div>EVEN</div>
};

export default Even;