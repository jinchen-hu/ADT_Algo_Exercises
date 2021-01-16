## YAML elements

YAML elements are mostly based on K/V pairs `Name: Value`

### Begin/End

This is **optional**. To start a document insert '---' at the top of the document, to end it, insert '...'

### Comments

`#`

### Scalar

Simple KV paris, 

* key: value
* someNumber: 99
* quotedText: "some text description"
* moreQuotedText: unnecessary to be quoted
* boolean: true
* space can occur in key: and also in value
* nullKeyValue: null
* nullValue: ~
* date: yyyy-mm-dd
* datetime: yyyy-mm-dd**T**hh:mm+xx:00 -->plus the timezone

### Collections & Lists

List and collection members are lines that begin at the same indentation level, starting with a dash followed by a space

```yaml
companies:
  - Facebook
  - Google
  - Amazon
  
companies:
  - 
  	id: 1
  	name: Facebook
  - 
    id: 2
    name: Google
    
companies: [{id: 1, name: Facebook},{id:2, name: Google}]
```

### Nested collections

```yaml
drivers:
	- 
	  name: Sam
	  age: 21
	
```

