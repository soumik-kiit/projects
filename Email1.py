import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart

def send_email():
    # Email information
    sender_email = 'test@teegasm.shop'
    sender_password = 'Test@123'
    recipient_email = 'soumik.chowdhury797@gmail.com'
    subject = 'Your hotel is booked'
    message = 'Dear recipient, your hotel has been successfully booked.'

    # Create the email message
    email_message = MIMEMultipart()
    email_message['From'] = sender_email
    email_message['To'] = recipient_email
    email_message['Subject'] = subject
    email_message.attach(MIMEText(message, 'plain'))

    # Connect to the SMTP server
    with smtplib.SMTP('smtp.hostinger.com', 465) as server:
        server.starttls()
        server.login(sender_email, sender_password)

        # Send the email
        server.send_message(email_message)
        print("Email sent successfully!")

# Call the function to send the email
send_email()
