import React from "react";
class DemoClass extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            name: 'Chú linh',
            age:5
        }
    }

    render() {
        return <h1>Day la class component
        <p>Tên là {this.state.name}</p>
        <p>Tuổi là {this.state.age}</p>
        {/*<p>Abc là {this.props.abc}</p>*/}
            <button onClick={() => this.setState({age:this.state.age + 1})}>Thay đổi</button>
        </h1>;
    }

}
export default DemoClass
