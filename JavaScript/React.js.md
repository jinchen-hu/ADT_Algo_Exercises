# React

React is a declarative, efficient, and flexible JavaScript library for building user interfaces. It lets you compose complex UIs from small and isolated pieces of code called 'components'

## ReactDOM

* Render a React element into the DOM in the supplied container and return a reference to the component, or null for stateless components
  * if the element was previously rendered into container, this will perform an update on it and only mutate the DOM as necessary to reflect the latest React element
  * if the optimal callback is provides, it will be executed after the componet is redered or updated

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

