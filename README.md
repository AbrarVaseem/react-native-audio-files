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

//Or Follow Basic Example:

```js
import { fetchAudioFiles } from 'react-native-audio-files';

const [audioFiles, setAudioFiles] = useState([]);

useEffect(() => {
  const getAudioFiles = async () => {
    return await fetchAudioFiles();
  };
  getAudioFiles().then((result) => {
    setAudioFiles(result);
  });
}, []);

return (
  <View>
    {audioFiles?.map((element, index) => {
      return (
        <View key={index}>
          <Text>{element?.title}</Text>
        </View>
      );
    })}
  </View>
);
```

## List of keys available:

| Key           | Description                       | Type    |
|---------------|-----------------------------------|---------|
| __addedDate__ | Added Date Time of the Audio File | String  |
| __album__     | Album of the Audio File           | String  |
| __artist__    | Artist of the Audio File          | String  |
| __audioUrl__  | Path of the Audio File            | String  |
| __duration__  | Duration of the Audio File        | Integer |
| __id__        | Unique Id of the Audio File       | String  |
| __imageUrl__  | Image of the Audio File           | String  |
| __size__      | Size of the Audio File            | String  |
| __title__     | Title of the Audio File           | String  |

__Note:__
1. __addedDate__ is of type UNIX Timestamp, to convert it into the required time format of __YYYY-MM-DD HH:MM:SS__

```js
const formattedDateTime = new Date(addedDate * 1000).toISOString().slice(0, 19).replace('T', ' ');
```

2. __Make sure you have permissions granted from User for Reading Storage according to the Android Versions or you wont be able to fetch files.__

```js
Example: <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
```


## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT