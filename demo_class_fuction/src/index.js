import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from "./App";


const root = ReactDOM.createRoot(document.getElementById('root'));

class Greeting extends React.Component {
    render() {
        return <App/>
    }
}
root.render(<Greeting/>);


// function Greeting() {
//     return <h2>Hello C0822G1</h2>;
// }


