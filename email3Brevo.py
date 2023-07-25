import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart

def send_email():
    # SMTP server information
    host = "smtp-relay.sendinblue.com"
    port = 587

    # Sender and recipient information
    from_email = "mythorganization.beta@gmail.com"
    to_email = "chamakchoudhuri@gmail.com"  # Replace with the recipient's email address

    # Sender's credentials (authentication)
    username = "mythorganization.beta@gmail.com"
    password = "O3Jn96LSIQREczb8"

    # Set the properties
    smtp_server = smtplib.SMTP(host, port)
    smtp_server.starttls()
    smtp_server.login(username, password)

    try:
        # Create a message
        message = MIMEMultipart()
        message["From"] = from_email
        message["To"] = to_email
        message["Subject"] = "Test Email from Python"
        body = "This is a test email sent from Python using the smtplib library."
        message.attach(MIMEText(body, "plain"))

        # Send the message
        smtp_server.sendmail(from_email, to_email, message.as_string())

        print("Email sent successfully!")
    except smtplib.SMTPException as e:
        print("Error: Unable to send email.")
        print(e)
    finally:
        smtp_server.quit()

if __name__ == "__main__":
    send_email()
