package com.devpredator.tiendamusicalweb.paypal;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
/**
 * 
 * @author DevPredator
 * Clase Client de PayPal que configura las clases necesarias para realizar las transacciones 
 * hacia PayPal y tambien el CLIENT ID y SECRET ID de acceso a la aplicacion de Sandbox.
 */
public class PayPalClient {

  /**
   *Set up the PayPal Java SDK environment with PayPal access credentials.  
   *This sample uses SandboxEnvironment. In production, use LiveEnvironment.
   */
  private PayPalEnvironment environment = new PayPalEnvironment.Sandbox(
    "ATEir5IbJm02uOzMfNPZw48iYRuJsoScedFxjThUfQnB1eh5Soal3FAWUQsfFettOs11DDURnRxXiQBo",
    "EN2296CBA-8sjbQHNkNp1INJDbJcpXPzpoHQUqXVKZm0f9ycr6qZrkKJnddHCIepugFXic7RPJHOMBzc");

  /**
   *PayPal HTTP client instance with environment that has access
   *credentials context. Use to invoke PayPal APIs.
   */
  PayPalHttpClient client = new PayPalHttpClient(environment);

  /**
   *Method to get client object
   *
   *@return PayPalHttpClient client
   */
  public PayPalHttpClient client() {
    return this.client;
  }
}