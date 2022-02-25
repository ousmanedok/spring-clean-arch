import * as React from "react";
import {StyleSheet , Text} from 'react-native';
import { Card, Title, Paragraph  } from 'react-native-paper';
import moment from "moment";

const ArticleElement = (props) =>{
    const date = moment(props.publishedDate).format('ddd D MMM YYYY HH:mm');
    return(
        <Card style={styles.container}>

            <Card.Cover source={{ uri: props.imageUrl }} />
            <Card.Content>
                <Title>{props.title}</Title>
                <Text>
                    <Text>{props.siteName}</Text>
                    <Text style={styles.date}>{date}</Text>
                </Text>
                <Paragraph>{props.content}</Paragraph>
                <Text>{props.author}</Text>
            </Card.Content>
            
        </Card>
            
    );
}
const styles = StyleSheet.create({
    container :{
        margin : 20,
        elevation : 5
     },
    date : {
        paddingLeft:20
    }
});
export default ArticleElement;