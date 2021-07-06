# Sketchware-ProjectManager
a simple library to manage sketchware
[![](https://jitpack.io/v/Bhavy-Ukani/Sketchware-ProjectManager.svg)](https://jitpack.io/#Bhavy-Ukani/Sketchware-ProjectManager)

This is the simple library to manage sketchware resources something like

- Encryption /Decryption

- Project List / MoreBlock / widgets ( Json )

- Makeing Project Zip

- Share Project , MoreBlock , widgets

### Add it in your root build.gradle at the end of repositories:

```bash

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

```

### Add the dependency

```bash

dependencies {

	        implementation 'com.github.Bhavy-Ukani:Sketchware-ProjectManager:Tag'

	}

```

# Features

#### 1 Decode encrypted file

```bash

String decoded = ProjectManager.Decode("Your file path");

```

#### 2 Encode Decrypted file

```bash

boolean encoded = ProjectManager.Decode("decoded String", "path to save in file");

```
#### 3 All Projects List

```bash

String list = ProjectManager.Projects();

or in Listmap
map = new Gson().fromJson(ProjectManager.Projects(), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());


```
