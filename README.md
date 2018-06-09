# Build it Bigger

Used Gradle to build a joke-telling app that has both a free and paid version. This included factoring functionality into libraries as well as using build flavors to modularize the construction of each variant of the app. I also configured a Google Cloud Endpoints development server to supply the jokes.

## Why this Project

As Android projects grow in complexity, it becomes necessary to customize the
behavior of the Gradle build tool, allowing automation of repetitive tasks.
Particularly, factoring functionality into libraries and creating product
flavors allow for much bigger projects with minimal added complexity.

## What Will I Learn?

You will learn the role of Gradle in building Android Apps and how to use
Gradle to manage apps of increasing complexity. You'll learn to:

* Add free and paid flavors to an app, and set up your build to share code between them
* Factor reusable functionality into a Java library
* Factor reusable Android functionality into an Android library
* Configure a multi project build to compile your libraries and app
* Use the Gradle App Engine plugin to deploy a backend
* Configure an integration test suite that runs against the local App Engine development server

## Project Overview
This multi-project build will look something like this:

<img width="734" alt="screen-shot-2017-10-31-at-3 54 32-pm" src="https://user-images.githubusercontent.com/26686429/41132376-b9469896-6ab8-11e8-8121-a9c84c762a93.png">

## Screenshots
![screenshot_1528325052](https://user-images.githubusercontent.com/26686429/41132415-0fb0d020-6ab9-11e8-8b73-48c47eec3a18.png)
![screenshot_1528325075](https://user-images.githubusercontent.com/26686429/41132416-0fc6e144-6ab9-11e8-95a3-5c459fcd11b8.png)
![screenshot_1528325135](https://user-images.githubusercontent.com/26686429/41132417-0fdd0f8c-6ab9-11e8-8fc5-7516b6dbe1c3.png)
