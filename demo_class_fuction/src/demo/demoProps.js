import {useState} from "react";

function DemoFunction(props) {
    const [state, setState] = useState({
        name: 'Cường',
        age: 1
    })
    return <div><h1>Day la function component  {props.name} và số tuổi là {props.age}</h1>
    </div>
}

export default DemoFunction
