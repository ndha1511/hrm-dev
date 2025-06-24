# Setup & Install

## 1. Windows PowerShell

#### install apps

```
winget install --id Microsoft.VisualStudioCode -e --silent
winget install --id Postman.Postman -e --silent
```

#### vs code

```
code --install-extension ms-vscode-remote.remote-wsl
```

#### create shortcut

```
$WshShell = New-Object -ComObject WScript.Shell

$workspaces = @(
    @{ Name = "HRM-System";        Path = "/root/hrm-system/hrm-system.code-workspace" },
    @{ Name = "HRM-Front";         Path = "/root/hrm-system/hrm-front/hrm-front.code-workspace" },
    @{ Name = "HRM-API";           Path = "/root/hrm-system/hrm-api/hrm-api.code-workspace" },
    @{ Name = "OpenAPI-TypeSpec";  Path = "/root/hrm-system/openapi-typespec/openapi-typespec.code-workspace" }
)

foreach ($ws in $workspaces) {
    $shortcutPath = "$env:USERPROFILE\Desktop\$($ws.Name).lnk"

    $shortcut = $WshShell.CreateShortcut($shortcutPath)
    $shortcut.TargetPath = "wsl.exe"
    $shortcut.Arguments = "code `"$($ws.Path)`""
    $shortcut.Description = "Open VS Code workspace in WSL: $($ws.Name)"

    $shortcut.Save()
    Write-Host "created shortcut: $shortcutPath"
}

```

#### install wsl

```
wsl --install
```

```
restart pc

wsl
```

## 2. Linux Ubuntu

#### upgrade

```
sudo su

apt update

apt upgrade -y
```

```
apt install git -y

apt install gh -y

apt install jq -y

apt install maven -y

apt install openjdk-21-jre-headless -y

apt install docker.io -y
```

#### install nodejs

```
curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.40.3/install.sh | bash

\. "$HOME/.nvm/nvm.sh"

nvm install 22
```

#### github

###### login

```
BROWSER=/mnt/c/Windows/explorer.exe gh auth login
```

###### download source code

```
git clone https://github.com/ndha1511/hrm-dev.git

```

## 3. Setup environment

#### open workspace

```
code "/root/hrm-system/hrm-system.code-workspace"
```

##### Run task -> Setup Environment
