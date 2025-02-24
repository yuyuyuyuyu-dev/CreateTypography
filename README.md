# CreateTypography
A library for Android and Compose Multiplatform, provide functions that create Typography from font name or FontFamily.


## Installation
### Android
app/build.gradle.kts
```diff
dependencies {
    ...

+   implementation("dev.yuyuyuyuyu:createtypography:0.1.0")
}
```

### Compose Multiplatform
composeApp/build.gradle.kts
```diff
kotlin {
...

    sourceSets {
        ...

        commonMain.dependencies {
            ...

+           implementation("dev.yuyuyuyuyu:createtypography:0.1.0")
        }
    }
}

```


## Screenshots
### Android

<img width="300" alt="Android Screenshot" src="https://github.com/user-attachments/assets/e2f31fc3-7a8f-4578-bc6f-bd14d50161f4" />

### Compose Multiplatform

<img width="600" alt="Compose Multiplatform Screenshot" src="https://github.com/user-attachments/assets/d0a4d32a-5816-4d69-9667-77aec0e99644" />


## Examples
### Android
[app/src/main/java/dev/yuyuyuyuyu/createtypography/example/android/ui/theme/Type.kt](https://github.com/yu-ko-ba/CreateTypography/blob/main/app/src/main/java/dev/yuyuyuyuyu/createtypography/example/android/ui/theme/Type.kt)
```kotlin
val Typography = createTypographyFrom(fontName = "Yomogi")
```

### Compose Multiplatform
[composeApp/src/commonMain/kotlin/dev/yuyuyuyuyu/createtypography/example/multiplatform/App.kt](https://github.com/yu-ko-ba/CreateTypography/blob/main/composeApp/src/commonMain/kotlin/dev/yuyuyuyuyu/createtypography/example/multiplatform/App.kt)
```kotlin
@Composable
fun App() {
    MaterialTheme(
        typography = createTypographyFrom(fontFamily = FontFamily(Font(Res.font.Yomogi_Regular))),
    ) {
        Scaffold { innerPadding ->
            Box(
                modifier = Modifier.padding(innerPadding),
            ) {
                Text(
                    text = "Hello, ${getPlatform().name}!",
                )
            }
        }
    }
}
```


## License
Apache License 2.0
```
Copyright 2025 yu

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
