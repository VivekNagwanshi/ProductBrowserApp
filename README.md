# Product Browser App (Kotlin Multiplatform)

## Overview

This project is a **Kotlin Multiplatform Mobile (KMM)** application built using **Compose Multiplatform**.
The app demonstrates a simple **cross-platform product catalog** that runs on **Android and iOS** using a shared codebase.

The application consumes product data from the public API:

https://dummyjson.com/docs/products

The goal of this project is to showcase:

* Clean architecture
* Shared UI using Compose Multiplatform
* API integration using Ktor
* State management using StateFlow

---

# Business Requirements

The application allows users to:

1. **View a list of products**

   * Displays product title
   * Displays product price
   * Displays product thumbnail

2. **View product details**

   * Product title
   * Description
   * Brand
   * Price
   * Rating
   * Product images

3. **Search products**

   * Search products using keywords
   * Results fetched from the API

4. **Cross-platform support**

   * Runs on both Android and iOS using Kotlin Multiplatform.

---

# Architecture

The project follows **Clean Architecture** principles and separates the code into the following layers:

## 1. Presentation Layer

Responsible for UI and state handling.

Technologies used:

* Compose Multiplatform
* ViewModel
* StateFlow

Components:

* `ProductListScreen`
* `ProductDetailScreen`
* `ProductViewModel`

---

## 2. Domain Layer

Contains business logic and use cases.

Use cases implemented:

* `GetProductsUseCase`
* `SearchProductsUseCase`

Domain also contains:

* Repository interfaces
* Domain models

---

## 3. Data Layer

Responsible for fetching and managing data.

Components:

* `ProductApi` (Ktor client API)
* `ProductRepositoryImpl`
* DTO models
* API response parsing using `kotlinx.serialization`

---

# Tech Stack

* **Kotlin Multiplatform (KMM)**
* **Compose Multiplatform**
* **Ktor Client**
* **kotlinx.serialization**
* **StateFlow**
* **Landscapist / Ktor Image Loader**
* **Clean Architecture**

---

# Project Structure

```
composeApp
│
├── data
│   ├── api
│   │   └── ProductApiImpl
│   ├── repository
│   │   └── ProductRepositoryImpl
│   └── model
│
├── domain
│   ├── model
│   ├── repository
│   └── usecase
│
├── presentation
│   ├── viewmodel
│   │   └── ProductViewModel
│   └── ui
│       ├── ProductItem
│       ├── ProductListScreen
│       └── ProductDetailScreen
│
└── App.kt
```

---

# Features Implemented

* Product list screen
* Product detail screen
* API-based product search
* Image loading
* Shared UI for Android and iOS
* Clean architecture structure
* Basic unit test for use case

---

# API Endpoints Used

Get Products

```
https://dummyjson.com/products
```

Search Products

```
https://dummyjson.com/products/search?q={query}
```

---

# How to Run the Project

## Android

1. Clone the repository

```
git clone https://github.com/VivekNagwanshi/ProductBrowserApp.git
```

2. Open the project in **Android Studio (latest version recommended)**.

3. Sync Gradle.

4. Run the app using the Android configuration.

---

## iOS

1. Open the project in **Xcode**.

2. Navigate to:

```
iosApp
```

3. Run the project on the **iOS Simulator**.

---

# Unit Testing

A basic unit test is included for the domain layer.

Example tested component:

```
GetProductsUseCase
```

The test verifies that product data is correctly returned from the repository.

---

# Assumptions & Trade-offs

* Pagination was not implemented to keep the prototype simple.
* Error handling and loading states were kept minimal.
* Dependency Injection was implemented manually instead of using frameworks like Koin or Hilt.
* The UI focuses on functionality rather than full production design.

---

# Future Improvements

Possible enhancements:

* Pagination support
* Category filtering
* Product image carousel
* Loading indicators and error states
* Dependency injection (Koin)
* UI animations
* Offline caching

---

# Screens

## Product List

Displays product thumbnail, title, and price.

## Product Details

Displays detailed information including:

* title
* description
* brand
* price
* rating
* images

---

# Author

Vivek Nagwanshi
Android Developer | Kotlin | Kotlin Multiplatform | Jetpack Compose

---
