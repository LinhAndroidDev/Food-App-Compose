# Food App - Jetpack Compose

A modern food delivery application built with Jetpack Compose, following Material Design 3 guidelines.

## App Screenshots
1. Home Screen
   
   <img src="https://github.com/user-attachments/assets/1952c993-4ae5-41d8-83dd-19f35d4a294f" width="300" />

2. Cart Screen

   <img src="https://github.com/user-attachments/assets/b6659f03-0689-4d3f-8020-5e3599da419c" width="300" />

## Features

- **Bottom Navigation**: Easy navigation between different sections of the app
  - Home
  - Favorites
  - Cart
  - Extensions
  - Profile

- **Home Screen**:
  - Welcome header with user greeting
  - Food category horizontal scrolling list
  - Promotional banner with gradient overlay
  - Best sellers grid layout
  - Search and notification icons

- **Material Design 3**: Modern UI components and animations
- **Navigation**: Seamless navigation between screens using Navigation Compose
- **Responsive Layout**: Adapts to different screen sizes and orientations

## Technical Stack

- **Kotlin**: Primary programming language
- **Jetpack Compose**: Modern UI toolkit
- **Material Design 3**: UI components and theming
- **Navigation Compose**: Navigation between screens
- **Coil**: Image loading library
- **State Management**: Using Compose's state management system

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/firstjetpackcompose/
│   │   │       ├── MainActivity.kt
│   │   │       ├── screen/
│   │   │       │   ├── BottomNavigationBar.kt
│   │   │       │   ├── BottomNavigationItem.kt
│   │   │       │   ├── home/
│   │   │       │   │   └── HomeScreen.kt
│   │   │       │   ├── cart/
│   │   │       │   │   └── CartScreen.kt
│   │   │       │   ├── ExtensionScreen.kt
│   │   │       │   ├── FavouriteScreen.kt
│   │   │       │   └── ProfileScreen.kt
│   │   │       └── ui/
│   │   │           └── theme/
│   │   └── res/
│   │       └── drawable/
```

## Getting Started

1. Clone the repository
2. Open the project in Android Studio
3. Sync the project with Gradle files
4. Run the app on an emulator or physical device

## Dependencies

- AndroidX Core
- Jetpack Compose
- Material Design 3
- Navigation Compose
- Coil

## Contributing

Feel free to submit issues and enhancement requests.

## License

This project is licensed under the MIT License - see the LICENSE file for details.
