package com.email.response;


import javax.ws.rs.core.Response;

/**Class is responsible for sending back the outcome response for any email service call
 * Created by student on 10/21/16.
 */


public class EmailServiceResponse {
    public static final String SUCCESSFULLY_SENT = "Email was successfully sent";
    public static final String SEND_FAIL = "System Error: Email failed in transit..Please try again later";
    public static final String INVALID_PAYLOAD = "Invalid email format";
    public static final String SERVER_BUSY= "Server Busy...Please try again later";
    public static final String UNKNOWN_USER= "Email service failed. Invalid request credentials";
    private static final String ILLEGAL_ARGUMENT_MESSAGE = "Unknown response type requested";

    /**Method that generates and return the response type
     * @param responseType the type of reponse to generate
     * @return Generated response
     * @throws IllegalArgumentException if an appropriate response type is not provided
     */
    public static Response response(String responseType) throws IllegalArgumentException {
        //TODO: return  responses for each case
        switch (responseType){
            case SUCCESSFULLY_SENT: {
                return Response.status(200).entity(SUCCESSFULLY_SENT).build();
            }
            case SEND_FAIL: {

                return Response.status(204).entity(SEND_FAIL).build();
            }
            case SERVER_BUSY: {

                return Response.status(204).entity(SERVER_BUSY).build();
            }
            case INVALID_PAYLOAD: {

                return Response.status(204).entity(INVALID_PAYLOAD).build();
            }
            case UNKNOWN_USER: {

                Response.status(204).entity(UNKNOWN_USER).build();
            }
            default: {

                    responseType = responseType.substring(0,25);
                    return Response.status(200).entity(responseType).build();
                }
            }
                //throw  new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }

    }

