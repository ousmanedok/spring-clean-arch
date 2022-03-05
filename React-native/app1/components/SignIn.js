import React, { useEffect, useState } from "react";
import { Card, Title  } from "react-native-paper";
import {StyleSheet, View , Button , Text , ScrollView} from 'react-native';
import InputText from "./inputText";
import PasswordInput from "./passwordInput";
import SigninHeader from "./signinHeader";
import * as Yup from "yup";
import { Controller, useForm } from "react-hook-form";
import {yupResolver} from "@hookform/resolvers/yup";
import { signin } from "../actions/user";
import { useDispatch, useSelector } from "react-redux";

const SignIn = ({navigation}) =>{

    const validationSchema = Yup.object({
        email:                  Yup.string()
                                   .email("Veuillez saisir une adresse mail valide") 
                                   .required("Veuillez saisir une adresse mail"),
        motDePasse:             Yup.string()
                                   .min(6, "Veuillez saisir au moins 6 caractères")
                                   .required("Veuillez saisir le mot de passe")           
    }).required();

    const {
        control , 
        handleSubmit , 
        clearErrors,
    } = useForm({
        resolver: yupResolver(validationSchema),
    });
    const dispatch = useDispatch();
    const isLoggedIn = useSelector(state => state?.userReducer.isLoggedIn);
    const isLogInFail = useSelector(state => state?.userReducer.isLogInFail);

    const Signin = (user) =>{
        clearErrors();
        dispatch(signin(user));
    }

    useEffect(()=>{
        if(isLoggedIn){
            navigation.navigate('Home');
        }
    }, [isLoggedIn]);

    return (
            <ScrollView>
                <SigninHeader/>
                <Card style = {styles.card}>
                    <Card.Content>
                            <Title style = {styles.title}>Sign In</Title>
                            { isLogInFail && (
                                    <Text style={styles.error}>email ou mot de passe incorrect</Text>
                                 )
                            }
                            <Controller control={control} name="email" render={({field: {onChange , value} , fieldState: {error}}) => (
                                    <InputText 
                                        placeholder ="Email" 
                                        value={value} 
                                        onChangeText={onChange} 
                                        key = {3}
                                        error={error}
                                        errorDetails={error?.message}
                                    />
                            )}/>
                            <Controller control={control} name="motDePasse" render={({field: {onChange , value} , fieldState: {error}}) => (
                                <PasswordInput
                                placeholder="Mot de passe" 
                                    value={value} 
                                    onChangeText={onChange} 
                                    key={4}
                                    error={error}
                                    errorDetails={error?.message}
                                />
                            )}/>
                  </Card.Content>
                   <View style={styles.button}>
                        <Button              
                                title="Se connecter"
                                color="dodgerblue"
                                onPress={handleSubmit(Signin)}
                        />
                   </View>
                </Card>
                <View style={{ marginTop:40 }} >
                        <Text
                                style={styles.signup}
                                onPress={() => navigation.navigate('SignUp')}>
                                Vous n'avez pas de compte ? Inscrivez-vous
                        </Text>
                </View>
            </ScrollView>    
    );
}

const styles = StyleSheet.create({
    card: {
        marginTop: -50,
        marginHorizontal:30,
        elevation : 15,
    },
    title:{
        textAlign: 'center',
        textTransform : 'uppercase',
        color: 'dodgerblue',
        marginBottom : 10
    },
    button:{
        marginVertical: 30,
        paddingHorizontal:25
    },
    signup:{
        color: 'dodgerblue',
        textAlign: 'center'
    },
    error:{
        marginTop:4,
        fontSize:10,
        textAlign: 'center',
        color:'red'
    }
});
export default SignIn;
