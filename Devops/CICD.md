# CICD

## CI (Continuous Integration)

Continuous integration is a development practice that requires developers to integrate code into a shared repository several times a day. Each check-in is then verified by an automated build server, allowing teams to detect problem early.

* A single central repository where the code lives
* Developlers check-in/commit their code frequently
* Build should be triggered every time a developer checks in code 
* Build should be automatied and fast
* Build should compile the code as well as run automated
* Fixing a failed build shoud be top priority for the developers
* Build results should aways be communicated to all developers

### Stage 1: Push to master every day

The "push to master" stage is also known as **trunk-based development**

#### Feature flags

feature flags are an `if` condiftion determining whether to run the new code or not. If a change isn't complete yet, the flag is off by default. That way, when you integrate the code, the rest of the team has a chance to review it. The same technique applies if the new code has bugs.

### Stage 2: Rely on automated reliable tests

You might have to learn heavily on unit testing and lightly on integration testing

### Stage 3: Prioritize fixing a broken build

Everytime a build is broken, no one else can continue  pushing code changes.

Whoever breaks the build will try to fix the problem, and if help is needed, the rest of the team is there.

### Tools for CI

* Jenkins
* Azure Pipelines

## CD (Continuous Delivery)

Continuous delivery is a software development practice where software can be released to production any time. It is the ability to get changes of all types - including new features, configuration changes, bug fixes, and experiments - into production, or into the hands of users, safely and quickly in a sustainable way.

We achieve all this by ensuring our code is always in a deplyment state

* Correctness of automated scripts can be verified at creation time
* Automated scripts can easily pick the tasks for each environment
* Automation prevents the occurrence of human errors
* Autmated deployments, easily repeatable, lesser time to market

### Frequent small deployments

If you do deployments more often and work in small batches, the risk of doing deployments will be lower

### Autmation with a human touch

Automation helps to increase the sustainability of the process

## Typical CI/CD workflow

1. An engineer codes application changes using IDE
2. When the code is ready for integration, it's pushed to Git repository
3. CI automatically triggers the execution of test cases that will confirm that the code artifacts produces in the CI stage
4. In the application pipelines, the release pipeline triggers automatically to deploy the artifacts produced in the CI stage
5. An artifact is released into development environment
6. Application insigths collects information from the site to provide feedback to the team
7. The team uses the information available after a release to know the status and impact of the latest version
8. Any new feature or bug fix is added and prioritized into backlog

## Continuous Deployment

Continuous deployment is a software development practice where software is automatically released to production continuously 

## Trunk-based Development

When individuals on a team are committing their changes to the trunk multiple times a day it becomes easy to satisfy the core requirements of CI that all team members commit to trunk at least once each day. This ensures the codebase is always releasble on demand and helps to make CD a reality

Teams perform a full "pre-integrate" build (compile, unit test, integration tests) on their dev workstations before committing/pushing for others to see.

You can either do

* a direct to trunk commit/push, or
* a Pull-request workflow as long as those feature branches are short-lived and the product of a single person

Depending on the team size, and the rate of commits, **short-lived feature branches** are used for code-review and build checking (CI)

Depending on the intended release cadence, there may be **release branches** that are cut from the trunk on a just-in-time basis, are 'hardened' before a release, and **those branches are deleted** some time after release.

Teams should become adept with the related **branch by abstraction** techniques for longer to achieve changes, and use **feature flag** in day to day development to allow for hedging on the order of releases and **concurrrent development of consecutive releases**

You are going to hook up a **build server** to verify that their commits have not broken the build after landing in the trunk, and also when they are ready to be merged back into the trunk from a show-lived feature branch

