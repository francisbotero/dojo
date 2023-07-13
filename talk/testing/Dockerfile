FROM amazonlinux
RUN yum update -y && yum upgrade -y && yum install -y java-17-amazon-corretto-devel findutils unzip zip \
    && (curl -s "https://get.sdkman.io" | sh) && source "$HOME/.sdkman/bin/sdkman-init.sh" && sdk install gradle 8.2.1
