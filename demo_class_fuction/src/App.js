import logo from './logo.svg';
import './App.css';
import DemoClass from "./demo/demoClass";
import DemoFunction from "./demo/demoFunction";

function App() {
    let cuong = {
        name: 'cuong vlog',
        age: 3
    }


  return (
    <div className="App">
     <DemoClass abc={'oke'} name={'linh vlog'}/>
     {/*<DemoClass/>*/}
     {/*<DemoFunction />*/}
    </div>
  );
}

export default App;
