# react-native-audio-files

This package provides functionality to retrieve all audio files stored on an Android device. With this module, you can easily access and manage audio files within your React Native application.

## Installation

```sh
npm install react-native-audio-files
```

## Usage

```js
import { fetchAudioFiles } from 'react-native-audio-files';

const audioFiles = await fetchAudioFiles();
```

## List of keys available:

| Type    | Key       | Description                       |
|---------|-----------|-----------------------------------|
| String  | addedDate | Added Date Time of the Audio File |
| String  | album     | Album of the Audio File           |
| String  | artist    | Artist of the Audio File          |
| String  | audioUrl  | Path of the Audio File            |
| Integer | duration  | Duration of the Audio File        |
| String  | id        | Unique Id of the Audio File       |
| String  | imageUrl  | Image of the Audio File           |
| String  | size      | Size of the Audio File            |
| String  | title     | Title of the Audio File           |

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
