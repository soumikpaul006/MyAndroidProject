# Product Management Android App

An Android application that demonstrates modern Android development practices, including MVVM architecture, dependency injection with Hilt, Room database, Retrofit for network calls, and ViewPager2 for fragment navigation.

## Features

- Product submission with validation
- Local storage using Room database
- RESTful API integration
- Fragment-based navigation using ViewPager2
- Data sharing between fragments
- Network state handling
- Product list display using RecyclerView

## Architecture & Components

### Architecture Pattern
- MVVM (Model-View-ViewModel)
- Clean Architecture principles
- Repository pattern

### Libraries & Technologies
- **Hilt**: For dependency injection
- **Room**: Local database
- **Retrofit**: Network calls
- **ViewPager2**: Fragment navigation
- **Coroutines**: Asynchronous programming
- **LiveData**: Observable data holder
- **ViewModel**: UI state management
- **View Binding**: View access

## Key Components

### Data Layer
- **ProductEntity**: Room database entity for products
- **ProductDAO**: Data Access Object for Room operations
- **ProductApi**: Retrofit interface for API calls
- **ProductRepository**: Single source of truth for data operations

### UI Layer
- **MainActivity**: Entry point for product submission
- **FragmentActivity**: Hosts ViewPager2 with fragments
- **Fragment1 & Fragment2**: Data sharing demonstration
- **FetchActivity**: Displays product list

### Network
- **NetworkConnectionInterceptor**: Checks internet connectivity
- **NetworkUtils**: Network status utilities
- **ErrorHandler**: Centralized error handling

## Setup & Installation

1. Clone the repository
2. Open in Android Studio
3. Sync project with Gradle files
4. Run on an emulator or physical device

## API Integration

The app integrates with two REST APIs:
- Primary API: `https://api.restful-api.dev/`
- Secondary API: `https://jsonplaceholder.typicode.com/`

## Database Schema

### Products Table
- id (Primary Key)
- name
- price
- year
- cpuModel
- hardDiskSize

## Features in Detail

### Product Submission
- Input validation
- Network state checking
- Duplicate entry prevention
- Local and remote storage

### Data Sharing
- Bidirectional data flow between fragments
- Real-time updates using LiveData
- Shared ViewModel approach

### Error Handling
- Custom error messages
- Network state validation
- Input validation
- Exception handling

## Project Structure

```
com.codegalaxy.mock21nov/
├── model/
│   ├── Entity/
│   ├── dao/
│   ├── di/
│   ├── dto/
│   ├── remote/
│   └── repository/
├── view/
├── viewmodel/
└── utils/
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## Future Improvements

- Unit tests implementation
- UI tests
- Offline-first architecture
- Enhanced error handling
- Dark theme support
- Pagination for product list
- Search functionality

## Acknowledgements

This project integrates with and relies upon the following third-party services:

- [RESTful-API.dev](https://api.restful-api.dev/) - Primary API service for product management
- [JSONPlaceholder](https://jsonplaceholder.typicode.com/) - Secondary API service for testing and development

We thank these services for providing free, reliable API endpoints that make this project possible. Please check their respective documentation and terms of service when using these APIs in your own implementation.
