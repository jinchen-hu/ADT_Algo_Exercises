# React

React is a declarative, efficient, and flexible JavaScript library for building user interfaces. It lets you compose complex UIs from small and isolated pieces of code called 'components'

## ReactDOM

* Render a React element into the DOM in the supplied container and return a reference to the component, or null for stateless components
  * if the element was previously rendered into container, this will perform an update on it and only mutate the DOM as necessary to reflect the latest React element
  * if the optimal callback is provides, it will be executed after the component is rendered or updated

```react
ReactDOM.render(element, container[, callback])
```



## JSX

* JSX stands for JavaScript XML
* JSX allows us to write HTML in React
* JSX makes it easier to write and add HTML in React
* Can only have one root element -- one parent node

```javascript
function formatName(user) {
  return user.firstName + ' ' + user.lastName;
}

const user = {
  firstName: 'Harper',
  lastName: 'Perez'
};

const element = (
  <h1>
    Hello, {formatName(user)}!
  </h1>
);

ReactDOM.render(
  element,
  document.getElementById('root')
);
```

### Inline Styling

* JSX

```jsx
<button style={{backgroundColor:'blue', color: 'white'}}>Submit</button>
```

* HTML

```html
<div style="background-color:red; color: white;"></div>
```



## Component

A component is a

1. function, or
2. class

that produces HTML using **JSX** to show it to the user, and handles feedback from the user with **Event Handles**



![react-now](..\common\react-now.png)

### Component nesting

A component can be shown inside of another

### Create a reusable, configurable component

1. Identify the JSX that appears to be duplicated
2. What is the purpose of that block of JSX? Think of a descriptive name for what is does
3. Create a new file to house this new component - it should have the same name as the component
4. Create a new component in the new file, paste the JSX into it
5. Make the new component configurable by using React's 'props' system

### Props system

System for passing data from a parent component to a child component to customize or configure a child component

### Class component

* Must be a JavaScript Class

* Must extend React.Component

* Must define a 'render()' method that returns some amount of JSX

  ```react
  class App extends React.Component {
    constructor(props) {
      super(props);
  
      this.state = { lat: null };
  
      window.navigator.geolocation.getCurrentPosition(
        (position) => {
          this.setState({ lat: position.coords.latitude });
        },
        (err) => console.log(err)
      );
    }
    // must be overridden
    render() {
      return <div>Latitude: {this.state.lat} </div>;
    }
  }
  ```

  

### State

* Only usable with class components (technically can be used with functional components using 'hook')
* 'State' is a JS object that contains data relevant to a component
* Updating 'state' on a component causes the component to instantly rerender
* State must be initialized when a component is created
* State can only be updated using the function 'setState()'                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            



### Component lifecycle

* componentDidMount() --> good place to do data loading
* componentDidUpdate() --> good place to do more data loading when state/props change
* componentDidUnmount() --> good place to cleanup (especially for non-React stuff)



### Controlled elements

1. User types in input
2. Callback gets involved
3. We call setState() with the new value
4. Component re-renders
5. Input is told what its value is (coming from state)



## React Refs

* Give access to a single DOM element
* We create refs in the constructor, assign them to instance variables, then pass to a particular JSX element as props

## Hook System

* useState

  * function that lets you use state in a functional component
  * call useState() multiple times if there are more than one state values
  * the component will re-render anytime we call setters -- execute all codes except useState() functions

  ```react
  // [0] --> reference of the state that we are going to keep track of
  // [1] --> function we call to update the state
  // useState(initialState)
  const [activeIndex, setActiveIndex] = useState(null);
  
  // equivalent to the class component
  state = {activeIndex: null} //initialization
  useState(null);
  
  this.state.activeIndex  // reference
  ativeIndex;
  
  this.setState({activeIndex: 10}) // update
  setActiveIndex(10);
  
  // Equivalent
  const arr = useState(null);
  activeIndex = arr[0];  
  setActiveIndex = arr[1]; 
  ```

* useEffect
  * function that lets you use something like lifecycle methods in a functional component
  
  * we can configure the hook to run some codes automatically in one of three scenarios
    1. when the component is rendered for the first time only
    2. when the component is rendered for the first time and whenever it re-renders
    3. when the component is rendered for the first time and, whenever it re-renders and some piece of data has changed
    
  * first argument: the arrow function
  
    * if the function has a cleanup function with return statement, it will return the value returned in the last render
  
    ```react
    count = 0;
    useEffect(()=>{
    	console.log('initial render and each re-render');
    	return() => {console.log(count)}
    });
    setCount(count+1);
    // initial: initial render and each re-render
    // first re-render: 0 initial render and each re-render
    // second re-render: 1 initial render and each re-render
    ```
  
  * second argument
    * [] --> empty array
      * run at initial render
    * nothing
      * run at initial render
      * run after each re-render
    * [data] --> nonempty array
      * run at initial render
      * run after every re-render if data has changed since last render
* useRef
  
  * function that lets you create a 'ref' in a function component