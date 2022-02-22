import * as React from 'react';
import { Text, View } from 'react-native';

const ApiError = (props) =>{
    return(

        <View>
            {
                props.message && (
                    <Text>{props.message}</Text>
                )
            }
        </View>
        );
        
}

export default ApiError;