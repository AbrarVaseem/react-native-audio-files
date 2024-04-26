import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import { fetchAudioFiles } from 'react-native-audio-files';

export default function App() {
  const [result, setResult] = React.useState<any | undefined>();

  React.useEffect(() => {
    fetchAudioFiles().then(setResult);
  }, []);

  return (
    <View style={styles.container}>
      <Text>Result: {result}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
