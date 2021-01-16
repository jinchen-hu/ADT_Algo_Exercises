# GitHub Actions

![Component and service overview](https://docs.github.com/assets/images/help/images/overview-actions-design.png)

## Introduction

### Workflows

The workflow is an automated procedure that you add to your repository. Workflows are made up of one or more jobs and can be shchedule or triggered by an event.

### Events

An event is a specific activity that triggers a workflow.

single event: `on: push`

a list of events: `on: [push, pull_request]`

```yaml
on:
	push:
		branches:
			-main
```

### Jobs

A job is a set of steps that execute on the same runner. By default, a workflow with mutiple jobs will run those jobs in parallel.

### Steps

A step is an individual task that can run commands in a job. A step can be either an action or a shell command.

### Actions

Actions are standalone commands that are combined into steps to create a job.

### Runners

`ubuntu-latest, winds-latest, macos-latest`

### Dependet jobs

```yaml
jobs:
	setup:
		runs-on: ubuntu-latest
		steps:
			-run: ./setup.sh
	
	build:
		needs: setup # job id that depends on its successful completion
		runs-on: ubuntu-latest
		steps:
			-run: ./build.sh
			
```

### Build matrix

You can use build matrix to run tests across multiple combinations of operating systems, platforms, and languages.

### Template for Node.js

Add the file to `.github/workflows/`

```yaml
# the name of the workflows
name: Node.js CI

# event trigger
# can set up the workflow to run on certain branches, paths, or tages
on:
  push:
    branches: [ $default-branch ]
  pull_request:
    branches: [ $default-branch ]

# environment variable definitions
env:
	SEVER: production

# Groups together all the jobs
jobs:
	# job id
  setup:
  	name: set up the environment
		# specific runner on the current job
    runs-on: ubuntu-latest

    strategy:
      matrix:
        node-version: [10.x, 12.x, 14.x, 15.x]
		# groups together all the setps
    steps:
    - uses: actions/checkout@v2
    - name: Use Node.js ${{ matrix.node-version }}
      uses: actions/setup-node@v1
      with:
        node-version: ${{ matrix.node-version }}
    - run: npm ci
    - run: npm run build --if-present
    - run: npm test
    
  build:
  	name: build the project
  	needs: build
  	
  test:
  	name: test the product
  	needs: [setup, build]
```

## Composite Run Steps

A composite run steps action allow you to combine multiple workflow run steps within one action

Metadata file name must be **`action.yaml/yml`**

### Suppoted properties

* `name`: **required property**

  The name of the action

* `author`: **optional**

* `description`: **required property**

* `inputs`

  Input parameters allow you to specify data that the action expects to use during runtime

* `outputs`

* `id`

* `runs`: **required property**

* `env`

* `shell`

* `working-directory`

### Process

1. Create a new file called `action.yml`

2. Check in `action.yml`

3. Add a tag

   `git tag -a -m "Desrciption of this release" tagName`

   `git push --follow-tags`

```yaml
name: "Hello World"

description: "Greet Someone"

inputs:
  who-to-greet: # id of input
    description: "who to greet"
    required: true
    default: "World"

outputs:
  random-number:
    description: "Random number"
    value: ${{ steps.random-number-generator.outputs.random-id}}

runs:
  using: "composite"
  steps:
    - run: echo Hello ${{inputs.who-to-greet}}.
      shell: bash
    - id: random-number-generator
      run: echo '::set-output name=random-id::$(echo $RANDOM)'
      shell: bash
    - run: ${{github.action_path}}/goodbye.sh
      shell: bash

```

