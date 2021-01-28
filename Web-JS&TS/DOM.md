# DOM

* a standard for accessing documents: Document Object Model

* a standard object model and programming interface for HTML. It defines: the HTML elements as objects, the properties of all HTML elements, the methods to access all HTML elements, the events for all HTML elements. In other words, DOM is a standard for how to get, change, add, or delete HTML elements

  ![dom](..\common\dom.png)

getElemmentById(“id”); most common way to access an HTML element

​      finding an element by element id

getElementsByTagName(“tag”); find elements by tag name

getElementsByClassName(“class”); find elements by class name

​      return a Nodelist of all elements with the specified name or classname

​      element can be accessed through their node number

innerHTML; the easiest way to get and change the content of an element

setAttribut(“attribute”, “newvalue”); change the attribute of an element

style.attribute = newvalue; change the style of an element

 

document.createElement(element); create an html element

document.removeChild(element); remove an html element

document.appendChild(element); add an html element or element node

document.replaceChild(new, old); replace an html element

doucument.write(text); write in the html output stream

document.createTextNode(text); create an text node

 

document.forms.length; get the number of form elements

 

to add a new element to the HTML DOM, you must create the element (element node) first, and then append it to an existing element

 

node properties to navigate between nodes with js

​      parentNote, childNodes[nodenumber], firstChild, lastChild, nextSibling, previousSibling

 

**access elements:**

​      \1. DOM address: use the forms and element arrays of the Document object 

​      \2. Element names: requires the element and all of its ancestors (except body) to have name attributes

​      \3. getElementById method

 

**Navigation:**

​      nodeName—specifies the name of a node

​      nodeValue—specifies the value of a node                                                                                                                                     

 

**event attributes:**

​      onclick, onload, onmouseover, onmouseout, onblur,